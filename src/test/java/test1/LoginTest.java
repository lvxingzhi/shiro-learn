package test1;

import com.note.logic.BusinessLogic;
import org.junit.Test;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/11/21
 * @since 1.0
 */
public class LoginTest {

    @Test
    public void test(){
        BusinessLogic businessLogic = new BusinessLogic();
        // 认证
        String result = businessLogic.login("admin","123");
        System.out.println(result);

        // 授权
        String resultRole = businessLogic.hasRole("admin","123","adm5in");
        System.out.println(resultRole);

        // 访问控制
        String resultPermission = businessLogic.hasPermission("admin","123","all");
        System.out.println(resultPermission);

    }

}
