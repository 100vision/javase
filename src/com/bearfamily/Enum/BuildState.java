package com.bearfamily.Enum;

/*
    һ��Ҫ��ö�ٱ����Ķ�����ڵ�һ�У������ԷֺŽ�β��

    ���캯������˽�л�����ʵ�ϣ�private�Ƕ���ģ�����ȫû�б�Ҫд����Ϊ��Ĭ�ϲ�ǿ����private�������Ҫд��Ҳֻ��дprivate��дpublic�ǲ���ͨ������ġ�

    �Զ��������Ĭ�ϵ�ordinal���Բ�����ͻ��ordinal���ǰ������Ĺ����ÿ��ö�ٱ�����˳��ֵ��
 */

public enum BuildState {

    //��ö�ٱ�����������(int)
    NOTSTARTED(0),
    INITIAILIZING(1),
    OPEN(2),
    STARTED(3);


    private int value;

    //��ö�ٱ���������ʼֵ
    private BuildState(int value) {
        this.value=value;
    }

    //ö�ٻ��������ӷ���
    public boolean isOperatinal() {
        return value >= OPEN.value;
    }


}
