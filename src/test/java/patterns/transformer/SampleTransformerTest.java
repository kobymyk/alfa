package patterns.transformer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class SampleTransformerTest {
    private SampleTransformer sampleTransformer;
    @Before
    public void init() {
        SampleDto sampleDto = new SampleDto();
        sampleDto.id = "1";
        sampleTransformer = new SampleTransformer(sampleDto);
    }

    @Test
    public void transformed() {
        Transformer<SampleDto> transformer = sampleTransformer.transformer();
        //transformer=sample$lambda
        Function<SampleDto, Object> toObject = s -> (Object) s;
        Function<SampleDto, String> toString = Objects::toString;
        Function<SampleDto, List<String>> toList = s -> {
            List<String> result = new ArrayList<>();
            result.add(s.id);
            return  result;
        };

        Object o = transformer.by(toObject);
        String s = transformer.by(toString);
        Assert.assertTrue(s.contains("main.patterns.transformer.SampleDto"));
        Assert.assertTrue(transformer.by(toList).contains("1"));
    }
}
