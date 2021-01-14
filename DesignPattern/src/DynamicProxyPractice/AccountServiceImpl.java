package DynamicProxyPractice;

public class AccountServiceImpl implements IAccountService{

    @Override
    public int getSum(int a, int b) {
        return a+b;
    }

}
