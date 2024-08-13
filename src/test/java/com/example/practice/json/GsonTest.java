package com.example.practice.json;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class GsonTest {
    public static void main(String[] args) {
        BookmarkPO bookmarkPo = new BookmarkPO("twp","🛫twp_desc");
        Gson gson = new Gson();
        String resultJson = gson.toJson(bookmarkPo);
        System.out.println(resultJson);

        String outputPath = "E:\\_github\\waintang\\backendJava\\Bookmark_X.json";

        try (FileWriter fw = new FileWriter(outputPath)) {
            gson.toJson(bookmarkPo, fw);
        } catch (IOException e) {
            throw new RuntimeException("export error", e);
        }

    }

    public static class BookmarkPO {
        String name;
        String desc;

        public BookmarkPO(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
