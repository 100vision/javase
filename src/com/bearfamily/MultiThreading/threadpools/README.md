## �̳߳�

- ����corePoolSize, �̳߳��к����߳�����ֵ
- ����maxPoolSize, �̳߳��������ֵ

### �̳߳ص�ִ�в���

task --> blocking queue --> tread pool

- �����ǰ���߳���С��corePoolSize, �����񲻽���queue�Ŷӣ�ֱ�Ӵ������߳����У�ͼʾ��
 task --> pool
 
- �����ǰ�������߳�������corePoolSize��������ʼ����ѡ�������������У���������̣߳�ͼʾ��
task --> queue (q++) --> pool

- ����޷������������У��򴴽��µ��߳�, ���ǳ�����maxPoolSize��ͼʾ
task --> queue --> pool (thread++) --> Reject (if maxPoolSize exceeds)

### ������������
�̳߳صײ�ʹ�����������С����������У�
#### �޽����
- linkedBlockingQueue, �޽磬Ĭ��û�ж��д�С���ơ��̳߳�����newFixedThreadPool�ײ�ʹ�ã�

ȱ�㣺������ִ��ʱ��ϳ����ܻᵼ�´����������ڶ����жѻ�������Out of Memory�ڴ������
�ڴ�ܸ�

#### �н����
- ArrayBlockingQueue
- �н��LinkedBlockingQueue

ʹ���н����ʱ�����д�С���̳߳ش�С������ϡ�
�̳߳�С�ڶ��г��ȿ��Լ����ڴ����ģ�����cpu�������л��������������¡�
- minor changes
- major changes: