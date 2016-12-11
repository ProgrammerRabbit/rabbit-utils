package com.github.programmerrabbit.utils;

import com.github.programmerrabbit.test.Assert;
import com.github.programmerrabbit.test.Test;
import com.github.programmerrabbit.test.Tests;

/**
 * Created by yangwen on 2016/12/3.
 */
public class BeanUtilsTest {
    @Test
    public void testBeanUtils() {
        Source source = new Source(21, "杨文", "6100000000");
        Target target = new Target();
        BeanUtils.copyProperties(source, target);
        Assert.isTrue(21 == target.getAge());
        Assert.isTrue("杨文".equals(target.getName()));
    }

    public static void main(String[] args) {
        Tests.run(BeanUtilsTest.class);
    }

    private class Source {
        private int age;
        private String name;
        private String no;

        Source(int age, String name, String no) {
            this.age = age;
            this.name = name;
            this.no = no;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public String getNo() {
            return no;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNo(String no) {
            this.no = no;
        }
    }

    private class Target {
        private int age;
        private String name;

        public int getAge() {
            return this.age;
        }

        public String getName() {
            return this.name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
