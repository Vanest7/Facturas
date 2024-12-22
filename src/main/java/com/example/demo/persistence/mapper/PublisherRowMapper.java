package com.example.demo.persistence.mapper;

import com.example.demo.domain.models.Publisher;
import com.example.demo.persistence.mapper.common.CustomRowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherRowMapper implements CustomRowMapper<Publisher> {

    @Override
    public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setId(rs.getInt("books.id"));
        publisher.setName_es(rs.getString("books.title_es"));
        publisher.setSlug(rs.getString("publishers.slug"));
        return publisher;
    }
}
