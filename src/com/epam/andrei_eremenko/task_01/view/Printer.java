package com.epam.andrei_eremenko.task_01.view;

import com.epam.andrei_eremenko.task_01.module.Paradox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Printer<V> {
    private Consumer<V> consumer = (System.out::println);
    private BiConsumer<Paradox, File> biConsumer = (paradox, file) -> {

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write("\n" + paradox.toString());
            fileWriter.write("\n" + paradox.getResult());
            fileWriter.write("\n");
        } catch (IOException ex) {
            System.err.println("File not found");
            ex.printStackTrace();
        }
    };

    public void print(V v) {
        consumer.accept(v);
    }

    public void print(Paradox paradox, File file) {
        biConsumer.accept(paradox, file);
    }
}


