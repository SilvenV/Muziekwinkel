//package com.example.muziekwinkel.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import java.nio.charset.Charset;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@WithMockUser(username = "Admin", password="pass", authorities = {"ADMIN"})
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//public class LabelControllerTest {
//    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private static ObjectMapper mapper = new ObjectMapper();
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @Test
//    public void getLabel() throws Exception {
//        this.mockMvc.perform(get("/api/v3/labels/showlabel"))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
//
//    @Test
//    public void newLabel() {
//    }
//
//    @Test
//    public void deleteLabel() {
//    }
//
//    @Test
//    public void editLabelName() {
//    }
//
//    @Test
//    public void signArtistToLabel() {
//    }
//
//    @Test
//    public void removeArtistFromLabel() {
//    }
//}