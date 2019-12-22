package lang.methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ObjectAnyConvertUtils {
    Function<ObjectSrc, ObjectTarget> toTarget = ObjectAnyConvertUtils::toObjectTarget;
    Function<ObjectSrc, ObjectTargetInfo> toTargetInfo = (src) -> toObjectTargetInfo(src);
    Function<ObjectSrc, List<ObjectTargetItem>> toTargetItemList = (src) -> toObjectTargetItemList(src);

    public static ObjectTarget toObjectTarget(ObjectSrc src) {
        ObjectTarget target = new ObjectTarget();
        target.id = src.id.toString();
        return target;
    }

    public static ObjectTargetInfo toObjectTargetInfo(ObjectSrc src) {
        ObjectTargetInfo target = src.info != null ? toObjectTargetInfo(src) : new ObjectTargetInfo();
        return target;
    }

    public static ObjectTargetInfo toObjectTargetInfo(ObjectSrcInfo src) {
        ObjectTargetInfo target = new ObjectTargetInfo();
        target.info = src.text;
        return target;
    }

    public static List<ObjectTargetItem> toObjectTargetItemList(ObjectSrc src) {
        List<ObjectTargetItem> result = new ArrayList<>();
        if (src.items != null) {
            result = src.items.stream()
                    .map(ObjectAnyConvertUtils::toObjectTargetItem)
                    .collect(Collectors.toList());
        }
        return result;
    }

    public static ObjectTargetItem toObjectTargetItem(ObjectSrcItem src) {
        ObjectTargetItem target = new ObjectTargetItem();
        target.itemName = src.itemName;
        return target;
    }
}
