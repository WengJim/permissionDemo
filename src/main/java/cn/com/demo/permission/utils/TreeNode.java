package cn.com.demo.permission.utils;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;

/**
 * 树节点
 */
@Data
public class TreeNode<T> {
    private Long id;
    private Long parentId;
    private String parentName;
    private String name;
    private List<T> children;
    private Integer OrderNum;

    /**
     * 方法
     *
     * @param list
     * @return
     */
    public static <T extends TreeNode> List<T> toTrees(List<T> list) {
        List<T> treeList = Lists.newArrayList();
        for (int i = 0; i < list.size(); i++) {
            T tree = list.get(i);
            if (StringUtils.isEmpty(tree)){
                continue;
            }
            if (tree.getParentId() == 0) {
                treeList.add(tree);
            }
        }
        list.stream().sorted(Comparator.comparing(T::getOrderNum));
        for (T tree : list) {
            toTree(treeList, tree);
        }

        return treeList;
    }

    /**
     * 方法
     *
     * @param treeNode ,eos
     * @return
     */
    public static <T extends TreeNode> void toTree(List<T> treeList, T treeNode) {
        for (int i = 0; i < treeList.size(); i++) {
            T node =  treeList.get(i);
            if (treeNode.getParentId().equals(node.getId())) {
                if (node.getChildren() == null) {
                    node.setChildren(Lists.newArrayList());
                }
                treeNode.setParentName(node.getName());
                node.getChildren().add(treeNode);
            }
            if (node.getChildren() != null) {
                node.getChildren().stream().sorted(Comparator.comparing(T::getOrderNum)).sorted(Comparator.comparing(T::getId));
                toTree(node.getChildren(), treeNode);
            }
        }
        treeList.stream().sorted(Comparator.comparing(T::getOrderNum));
    }

    }
