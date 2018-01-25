package com.wxf.uitl.dataStructure.LinkedList;

/**
 * Created by wxf on 2018/1/18.
 * 链表顶级接口
 */
public interface ILinkedList<T> {
    /**
     * 判断链表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 链表长度
     * @return
     */
    int length();

    /**
     * 获取元素
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 设置某个结点的的值
     * @param index
     * @param data
     * @return
     */
    T set(int index, T data);

    /**
     * 根据index添加结点
     * @param index
     * @param data
     * @return
     */
    boolean add(int index, T data);

    /**
     * 添加结点
     * @param data
     * @return
     */
    boolean add(T data);

    /**
     * 根据index移除结点
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * 根据data移除结点
     * @param data
     * @return
     */
    boolean removeAll(T data);

    /**
     * 清空链表
     */
    void clear();

    /**
     * 是否包含data结点
     * @param data
     * @return
     */
    boolean contains(T data);


    /**
     * 输出格式
     * @return
     */
    String toString();

    /**
     * Created by wxf on 2018/1/18.
     * 带迭代器数组顶级接口
     */
    interface IList<T> {
       /**
        *  list大小
        * @return
        * */
        int size();

        /**
         * 是否为空
         * @return
         */
        boolean isEmpty();

        /**
         * 是否包含data
         * @param data
         * @return
         */
        boolean contains(T data);


        /**
         * 清空数据
         */
        void clear();

        /**
         * 根据index获取数据
         * @param index
         * @return
         */
        T get(int index);

        /**
         * 替换数据
         * @param index
         * @param data
         * @return
         */
        T set(int index, T data);

        /**
         * 尾部添加数据
         * @param data
         * @return
         */
        boolean add(T data);

        /**
         * 根据index添加数据
         * @param index
         * @param data
         */
        void add(int index, T data);

        /**
         * 移除数据
         * @param data
         * @return
         */
        boolean remove(T data);

        /**
         * 根据index删除数据
         * @param index
         * @return
         */
        T remove(int index);

        /**
         * 根据data获取下标
         * @param data
         * @return
         */
        int indexOf(T data);

        /**
         * 根据data获取最后一个下标
         * @param data
         * @return
         */
        int lastIndexOf(T data);

    }
}
