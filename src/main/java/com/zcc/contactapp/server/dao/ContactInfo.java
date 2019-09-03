package com.zcc.contactapp.server.dao;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

/**
 * Created by cc on 2019/4/2.
 */
@Data
@Entity(name = "zcc")
@Table(name = "contactors")
@Alias("contactinfo")
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "avatar_filename")
    private String avatarUrl;

    @Column(name = "title")
    private String title;

    @Column(name = "introduction")
    private String desc;
}
