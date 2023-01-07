package it.auties.whatsapp.model.poll;

import it.auties.protobuf.base.ProtobufMessage;
import it.auties.protobuf.base.ProtobufName;
import it.auties.protobuf.base.ProtobufProperty;
import it.auties.protobuf.base.ProtobufType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

/**
 * A model class that represents an option in a {@link it.auties.whatsapp.model.message.standard.PollCreationMessage}
 */
@AllArgsConstructor(staticName = "of")
@Data
@Accessors(fluent = true)
@Jacksonized
@Builder
@ProtobufName("PollOption")
public class PollOption
        implements ProtobufMessage {
    /**
     * The name of the option
     */
    @ProtobufProperty(index = 1, name = "name", type = ProtobufType.STRING)
    private String name;
}
