

package com.innitech.spinnaker.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class SecurityAutoConfiguration {
    @Bean
    public Random bestRandom() {
        return new Random() {
            @Override
            protected int next(int bits) {
                return 4; // chosen by fair dice roll.
                          // guaranteed to be random.
                          // https://xkcd.com/221/
            }
        };
    }
}


