package com.bearfamily.Enum;

/*
    一定要把枚举变量的定义放在第一行，并且以分号结尾。

    构造函数必须私有化。事实上，private是多余的，你完全没有必要写，因为它默认并强制是private，如果你要写，也只能写private，写public是不能通过编译的。

    自定义变量与默认的ordinal属性并不冲突，ordinal还是按照它的规则给每个枚举变量按顺序赋值。
 */

public enum BuildState {

    //给枚举变量代表数字(int)
    NOTSTARTED(0),
    INITIAILIZING(1),
    OPEN(2),
    STARTED(3);


    private int value;

    //给枚举变量赋赋初始值
    private BuildState(int value) {
        this.value=value;
    }

    //枚举还可以增加方法
    public boolean isOperatinal() {
        return value >= OPEN.value;
    }


}
