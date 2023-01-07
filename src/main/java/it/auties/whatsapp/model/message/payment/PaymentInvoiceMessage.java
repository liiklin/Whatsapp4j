package it.auties.whatsapp.model.message.payment;

import com.fasterxml.jackson.annotation.JsonCreator;
import it.auties.protobuf.base.ProtobufProperty;
import it.auties.whatsapp.model.media.AttachmentProvider;
import it.auties.whatsapp.model.message.model.MediaMessage;
import it.auties.whatsapp.model.message.model.MediaMessageType;
import it.auties.whatsapp.model.message.model.MessageType;
import it.auties.whatsapp.model.message.model.PaymentMessage;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.Arrays;

import static it.auties.protobuf.base.ProtobufType.*;

/**
 * A model class that represents a message to notify the invoice about a successful payment.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Jacksonized
@SuperBuilder
@Accessors(fluent = true)
public final class PaymentInvoiceMessage
        extends MediaMessage
        implements PaymentMessage {
    /**
     * The note of this invoice
     */
    @ProtobufProperty(index = 1, type = STRING)
    private String note;

    /**
     * The token of this invoice
     */
    @ProtobufProperty(index = 2, type = STRING)
    private String token;

    /**
     * The type of attachment that this invoice provides
     */
    @ProtobufProperty(index = 3, type = MESSAGE, implementation = AttachmentType.class)
    private AttachmentType type;

    /**
     * The mime type of the attachment that this invoice provides
     */
    @ProtobufProperty(index = 4, type = STRING)
    private String mimeType;

    /**
     * The media key of the attachment that this invoice provides
     */
    @ProtobufProperty(index = 5, type = BYTES)
    private byte[] mediaKey;

    /**
     * The media key timestamp of the attachment that this invoice provides
     */
    @ProtobufProperty(index = 6, type = UINT64)
    private long mediaKeyTimestamp;

    /**
     * The sha256 of the attachment that this invoice provides
     */
    @ProtobufProperty(index = 7, type = BYTES)
    private byte[] mediaSha256;

    /**
     * The sha256 of the encrypted attachment that this invoice provides
     */
    @ProtobufProperty(index = 8, type = BYTES)
    private byte[] mediaEncryptedSha256;

    /**
     * The direct path to the attachment that this invoice provides
     */
    @ProtobufProperty(index = 9, type = STRING)
    private String mediaDirectPath;

    /**
     * The thumbnail of the attachment that this invoice provides
     */
    @ProtobufProperty(index = 10, type = BYTES)
    private byte[] thumbnail;


    @Override
    public String mediaUrl() {
        return null;
    }

    @Override
    public AttachmentProvider mediaUrl(String mediaUrl) {
        return this;
    }

    @Override
    public long mediaSize() {
        return 0;
    }

    @Override
    public AttachmentProvider mediaSize(long mediaSize) {
        return this;
    }

    /**
     * Returns the media type of the media that this object wraps
     *
     * @return a non-null {@link MediaMessageType}
     */
    @Override
    public MediaMessageType mediaType() {
        return type == AttachmentType.IMAGE ?
                MediaMessageType.IMAGE :
                MediaMessageType.DOCUMENT;
    }

    @Override
    public MessageType type() {
        return MessageType.PAYMENT_INVOICE;
    }

    /**
     * The constants of this enumerated type describe the various types of attachment that an invoice can wrap
     */
    @AllArgsConstructor
    @Accessors(fluent = true)
    public enum AttachmentType {
        /**
         * Image
         */
        IMAGE(0),

        /**
         * PDF
         */
        PDF(1);

        @Getter
        private final int index;

        @JsonCreator
        public static AttachmentType of(int index) {
            return Arrays.stream(values())
                    .filter(entry -> entry.index() == index)
                    .findFirst()
                    .orElse(null);
        }
    }
}
