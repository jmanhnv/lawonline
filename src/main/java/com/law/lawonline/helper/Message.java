package com.law.lawonline.helper;

import lombok.*;

/**
 * A message to be displayed in web context. Depending on the type, different style will be applied.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    /**
     * Name of the flash attribute.
     */
    public static final String MESSAGE_ATTRIBUTE = "message";

    private int code;
    private String message;
    private String type;
    private Object[] args;

    public Message(String message, Type type, Object... args) {
        this.message = message;
        this.type = type.getType();
        this.args = args;
    }

    public Message(int code, String message, Type type, Object... args) {
        this(message, type, args);
        this.code = code;
    }

    /**
     * The type of the message to be displayed. The type is used to show message in a different style.
     */
    public enum Type {
        SUCCESS("success"), INFO("info"), WARNING("warning"), DANGER("danger");

        String type;

        Type(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
