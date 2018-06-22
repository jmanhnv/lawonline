package com.law.lawonline.helper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.law.lawonline.common.Constants;
import com.law.lawonline.model.Result;
import com.law.lawonline.model.ResultContainer;
import com.law.lawonline.model.SearchInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public final class RestApi implements Constants {
    private static final Logger logger = LoggerFactory.getLogger(RestApi.class);

    private static final String URL = "http://localhost:8080/api";
    private static final String SEARCH = "/search";

    public static List<Result> search(final SearchInput searchInput) {
        try {
            List<Result> results = Lists.newArrayList();

            URL url = new URL(URL + SEARCH);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(HttpMethods.POST);
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

            // Convert object to JSON string
            String input = mapper().writeValueAsString(searchInput);
            logger.info(input);

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes(UTF8));
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

            String output;
            logger.info("Output from Server...\n");

            while ((output = br.readLine()) != null) {
                logger.info(output);

                ResultContainer rsc = mapper().readValue(output, ResultContainer.class);
                results.addAll(rsc.getResult());
            }
            conn.disconnect();

            return results;
        } catch (MalformedURLException e) {
            logger.error(String.format("MalformedURLException in detail %s", e.getMessage()));
        } catch (IOException e) {
            logger.error(String.format("IOException in detail %s", e.getMessage()));
        }

        return Collections.EMPTY_LIST;
    }

    private static ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);

        return mapper;
    }

    /* valid HTTP methods */
    public class HttpMethods {
        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String PUT = "PUT";
        public static final String DELETE = "DELETE";
    }
}
