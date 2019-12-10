package patterns.persist.utils;

import patterns.persist.entity.DealDto;

import java.util.function.Function;

public class DealTransformer implements Transformable{
    private DealDto source;

    public DealTransformer(DealDto source) {
        this.source = source;
    }

    @Override
    public Transformer<DealDto> transformer() {
        return this::transform;
    }

    private <R> R transform(Function<? super DealDto, ? extends R> f) {
        return f.apply(this.source);
    }
}
