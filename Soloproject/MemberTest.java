package Projectmenual;


import java.util.ArrayList;
import java.util.Scanner;

import Member.MemberVo;

public class MemberTest {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		System.out.print("Input ename...?");
		Scanner sc = new Scanner(System.in);
		String inp = sc.next();
		
		System.out.println(inp);
		sc.close();
		
		ArrayList<MemberVo> list = dao.list(inp);
		for (int i = 0; i < list.size(); i++) {
			String ename = data.getPassword();
			int sal = data.getSal();

			System.out.println(empno + " : " + ename + ":" + sal);
		}

	}

}
