package com.freightcom.clickship.model.v2;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ShippingReponseDeserializer extends StdDeserializer<OneOfShippingDetailsPackagingProperties> {

	private static final long serialVersionUID = -5365263246855766054L;

	public ShippingReponseDeserializer() {
        this(null);
    }

    public ShippingReponseDeserializer(Class<?> vc) {
        super(vc);
    }

	@Override
	public OneOfShippingDetailsPackagingProperties deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectMapper mapper = (ObjectMapper) jp.getCodec();
	    
		ObjectNode root = (ObjectNode) mapper.readTree(jp);
	    
	    // Inspect the `dimensions` field to decide what to expect.
	    @SuppressWarnings("unused")
		String dimensions = root.get("shipment").get("details").get("packing_type").asText();
	    
		JsonNode node = jp.readValueAsTree();
        // Select the concrete class based on the existence of a property
        if (node.get("budget")!= null) {
            return jp.getCodec().treeToValue(node, PackagingPackage.class);
        }
        return jp.getCodec().treeToValue(node, PackagingPallet.class);
	}
}