package com.sandro.ecommercebackendspring.seeder;

import com.sandro.ecommercebackendspring.color.Color;
import com.sandro.ecommercebackendspring.color.ColorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ColorSeeder {

    private final ColorRepository colorRepository;

    @PostConstruct
    public void seedColors() {
        if (colorRepository.count() == 0) {
            List<Color> colors = Arrays.asList(
                    new Color("Red", "#FF0000"),
                    new Color("Blue", "#0000FF"),
                    new Color("Green", "#00FF00"),
                    new Color("Yellow", "#FF00FF"),
                    new Color("Orange", "#FFA500"),
                    new Color("Purple", "#800080"),
                    new Color("Pink", "#FFC0CB"),
                    new Color("Black", "#000000"),
                    new Color("White", "#FFFFFF"),
                    new Color("Brown", "#A52A2A"),
                    new Color("Gray", "#808080")
            );
            colorRepository.saveAll(colors);
        }
    }
}
