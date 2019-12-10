package patterns.transformer;

import java.util.function.Function;

public class SampleTransformer implements Transformable {
    private SampleDto source;

    public SampleTransformer(SampleDto source) {
        this.source = source;
    }

    @Override
    public Transformer<SampleDto> transformer() {
        // method reference
        return this::transform;
    }

    private <R> R transform(Function<? super SampleDto, ? extends R> f) {
        return f.apply(this.source);
    }
}
