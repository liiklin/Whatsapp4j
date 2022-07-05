package it.auties.whatsapp.model.message.button;

import it.auties.protobuf.api.model.ProtobufProperty;
import it.auties.whatsapp.model.info.ContextInfo;
import it.auties.whatsapp.model.message.model.ButtonMessage;
import it.auties.whatsapp.model.message.model.ContextualMessage;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import static it.auties.protobuf.api.model.ProtobufProperty.Type.*;

/**
 * A model class that represents a message that contains a response to a previous {@link ButtonStructureMessage}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(builderMethodName = "newTemplateButtonReplyMessage")
@Accessors(fluent = true)
public final class ButtonTemplateReplyMessage extends ContextualMessage implements ButtonMessage {
    /**
     * The id of the button that was selected from the previous template message
     */
    @ProtobufProperty(index = 1, type = STRING)
    private String id;

    /**
     * The text of the button that was selected from the previous template message
     */
    @ProtobufProperty(index = 2, type = STRING)
    private String displayText;

    /**
     * The context info of this message
     */
    @ProtobufProperty(index = 3, type = MESSAGE, concreteType = ContextInfo.class)
    @Builder.Default
    private ContextInfo contextInfo = new ContextInfo();  // Overrides ContextualMessage's context info

    /**
     * The index of the button that was selected from the previous template message
     */
    @ProtobufProperty(index = 4, type = UINT32)
    private int index;
}
