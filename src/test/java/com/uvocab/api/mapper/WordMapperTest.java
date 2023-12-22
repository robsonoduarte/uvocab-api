package com.uvocab.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import uvocab.protobuf.v1.Word;

class WordMapperTest {
  WordMapper mapper = new WordMapper();

  @Test
  void shouldMapperWordProtoToWordDomain() {
    var proto = Word.newBuilder().setWord("Home").build();
    var domain = mapper.toDomain(proto);
    assertEquals("Home", domain.getWord());
  }

  @Test
  void shouldMapperDomainToWordProto() {
    var domain = com.uvocab.api.domain.Word.builder().id(1).word("Home").build();
    var proto = mapper.toProto(domain);
    assertEquals(1, proto.getId());
    assertEquals("Home", proto.getWord());
  }
}
