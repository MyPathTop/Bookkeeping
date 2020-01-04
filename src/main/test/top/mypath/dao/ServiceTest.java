package top.mypath.dao;

        import org.apache.ibatis.io.Resources;
        import org.apache.ibatis.session.SqlSession;
        import org.apache.ibatis.session.SqlSessionFactory;
        import org.apache.ibatis.session.SqlSessionFactoryBuilder;
        import org.junit.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import top.mypath.commons.Result;
        import top.mypath.domain.Detail;
        import top.mypath.domain.Sort;
        import top.mypath.domain.User;
        import top.mypath.service.DetailService;
        import top.mypath.service.SortService;
        import top.mypath.service.UserService;
        import top.mypath.service.impl.UserServiceImpl;

        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Date;
        import java.util.List;

/**
 * @author 李亚林
 * @date 2019/12/22 16:51
 */
public class ServiceTest extends BaseTest{

    @Autowired
    private UserService userService;

    @Autowired
    private SortService sortService;
    @Test
    public void test() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession session=factory.openSession();
        UserDao userDao=(UserDao)session.getMapper(UserDao.class);
        List<User> userList=userDao.findAll();
        for (User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void userInsert(){
        User user=new User();
        user.setUserId("15858288380");
        user.setHead("head-icon");
        user.setUserName("你猜");
        user.setPassword("123456");
        user.setSex(1);
        user.setEmail("15858288380@qq.com");
        user.setMyBalance(0d);
        user.setCancel(1);
        userService.insert(user);
        System.out.println("插入程序结束");

    }

    @Test
    public void userFindById(){
        User user = userService.findById("15858288380");
        System.out.println(user);
    }

    @Test
    public void userUpdate(){
        User user=new User();
        user.setUserId("15858288380");
        user.setHead("head-icon-update");
        user.setUserName("修改");
        user.setPassword("123456");
        user.setSex(0);
        user.setEmail("15858288380@qq.com");
        user.setMyBalance(0d);
        user.setCancel(1);
        boolean flag=userService.updateUser(user);
        System.out.println(flag);
        System.out.println("修改数据结束。。。");
    }

    @Test
    public void sortInsertTest(){
        Sort sort=new Sort();
        sort.setSortName("礼物");
        sort.setIcon("&#xe609;");
        sort.setCancel(1);
        Integer insert = sortService.insert(sort);
        System.out.println(insert);
        System.out.println(sort.getSortId());
    }

    @Test
    public void sortUpdateTest(){
        Sort sort=new Sort();
        sort.setSortId(2);
        sort.setSortName("住房");
        sort.setIcon("&#xe653;");
        sort.setCancel(1);
        boolean insert = sortService.update(sort);
        System.out.println(insert);
    }

    @Autowired
    private DetailService detailService;

    @Test
    public void findDetailTest(){
        List<Detail> details=detailService.findMyDetails("15703816960",new Date());
        for(Detail detail:details){
            System.out.println(detail);
        }
    }

    @Test
    public void insertDetailTest(){
        Detail detail=new Detail();
        User user=new User();
        Sort sort=new Sort();
        user.setUserId("15703816960");
        sort.setSortId(2);
        detail.setUser(user);
        detail.setSort(sort);
        detail.setInOut(1);
        detail.setMoney(15864975d);
        detail.setRemark("拆迁赔偿款");
        detail.setCreateTime(new Date());
        detail.setCancel(1);
        boolean flag=detailService.insertDetail(detail);
        System.out.println(flag);
    }

    @Test
    public void updateDetailTest(){
        Detail detail=new Detail();
        User user=new User();
        Sort sort=new Sort();
        user.setUserId("15703816960");
        sort.setSortId(2);
        detail.setDetailId(4);
        detail.setUser(user);
        detail.setSort(sort);
        detail.setInOut(0);
        detail.setMoney(12864975d);
        detail.setRemark("买房");
        detail.setCreateTime(new Date());
        detail.setCancel(1);
        Result flag=detailService.updateDetail(detail);
        System.out.println(flag);
    }

    @Test
    public void deleteDetailTest(){
        User user=new User();
        user.setUserId("15703816960");
        Result result = detailService.deleteDetail(user, 3);
        System.out.println(result);
    }



}
