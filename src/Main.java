import com.sada.hibernate.DAO.EmployeeDAO;
import com.sada.hibernate.DAO.EmployeeDAOFactory;

public class Main {

	public static void main(String[] args) {
		EmployeeDAO dao=EmployeeDAOFactory.getInstance();
		dao.findEmp(10);
		System.out.println("=============");
		dao.findNames(40);

	}

}
