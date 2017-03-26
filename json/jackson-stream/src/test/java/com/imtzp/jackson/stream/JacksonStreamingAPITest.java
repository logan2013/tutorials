package com.imtzp.jackson.stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JacksonStreamingAPITest {

	@Test
	public void givenJsonGenerator_whenAppendJsonToIt_thenGenerateJson() throws IOException {

		// given
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		JsonFactory jFactory = new JsonFactory();
		JsonGenerator jGenerator = jFactory.createGenerator(stream, JsonEncoding.UTF8);

		// when
		jGenerator.writeStartObject();

		jGenerator.writeStringField("name", "Tom");
		jGenerator.writeNumberField("age", 25);

		jGenerator.writeFieldName("address");
		jGenerator.writeStartArray();

		jGenerator.writeString("Poland");
		jGenerator.writeString("5th avenue");

		jGenerator.writeEndArray();

		jGenerator.writeEndObject();
		jGenerator.close();

		// then
		String json = new String(stream.toByteArray(), "UTF-8");
		Assert.assertEquals(json, "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}");
	}

	@Test
	public void givenJson_whenReadItUsingStreamAPI_thenShouldCreateProperJsonObject() throws IOException {
		// given
		String json = "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}";
		JsonFactory jFactory = new JsonFactory();
		JsonParser jParser = jFactory.createParser(json);

		String parsedName = null;
		Integer parsedAge = null;
		List<String> addresses = new LinkedList<>();

		// when
		while (jParser.nextToken() != JsonToken.END_OBJECT) {

			String fieldName = jParser.getCurrentName();
			if ("name".equals(fieldName)) {
				jParser.nextToken();
				parsedName = jParser.getText();
			}

			if ("age".equals(fieldName)) {
				jParser.nextToken();
				parsedAge = jParser.getIntValue();
			}

			if ("address".equals(fieldName)) {
				jParser.nextToken();

				while (jParser.nextToken() != JsonToken.END_ARRAY) {
					addresses.add(jParser.getText());
				}
			}
		}
		jParser.close();

		// then
		Assert.assertEquals(parsedName, "Tom");
		Assert.assertEquals(parsedAge, (Integer) 25);
		Assert.assertEquals(addresses, Arrays.asList("Poland", "5th avenue"));
	}

	@Test
	public void givenJson_whenWantToExtractPartOfIt_thenShouldExtractOnlyNeededFieldWithoutGoingThroughWholeJSON()
			throws IOException {

		// given
		String json = "{\"name\":\"Tom\",\"age\":25,\"address\":[\"Poland\",\"5th avenue\"]}";
		JsonFactory jFactory = new JsonFactory();
		JsonParser jParser = jFactory.createParser(json);

		String parsedName = null;
		Integer parsedAge = null;
		List<String> addresses = new LinkedList<>();

		// when
		while (jParser.nextToken() != JsonToken.END_OBJECT) {

			String filedName = jParser.getCurrentName();
			if ("age".equals(filedName)) {
				jParser.nextToken();
				parsedAge = jParser.getIntValue();
				return;
			}
		}
		jParser.close();

		// then
		Assert.assertNull(parsedName);
		Assert.assertEquals(parsedAge, (Integer) 25);
		Assert.assertTrue(addresses.isEmpty());
	}
}
