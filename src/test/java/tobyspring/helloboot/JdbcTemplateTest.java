package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HellobootTest
public class JdbcTemplateTest {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @BeforeEach
  void init(){
    jdbcTemplate.execute("create table if not exists greeting (name varchar(50) primary key, count int)");
  }

  @Test
  void insertAndQuery(){
    jdbcTemplate.update("insert into greeting values (?, ?)", "Toby", 3);
    jdbcTemplate.update("insert into greeting values (?, ?)", "Yong", 1);

    int members = jdbcTemplate.queryForObject("select count(*) from greeting", int.class);
    Assertions.assertThat(members).isEqualTo(2);
  }
}