package sdu.zeen.servlet;

import com.google.gson.Gson;
import sdu.zeen.pojo.*;
import sdu.zeen.service.*;
import sdu.zeen.service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //更新商品列表
        getProducts();
        //分析操作符
        String oper=req.getParameter("oper");
        switch (oper)
        {
            case "login":
                login(req,resp);
                break;
            case "logout":
                logout(req,resp);
                break;
            case "cart":
                String type=req.getParameter("type");
                switch (type)
                {
                    case "check":
                        try {
                            checkShoppingCart(req,resp);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "add":
                        try {
                            addProduct(req,resp);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "delete":
                        try {
                            deleteProduct(req,resp);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                break;
            case "order":
                try {
                    checkOrder(req,resp);
                    resp.sendRedirect("orders.jsp");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "addorder":
                try {
                    addOrder(req,resp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("没有找到对应的操作符："+oper);
        }
    }

    private void getProducts(){
        //获取ServletContext
        ServletContext sc=this.getServletContext();
        //获取service层对象
        ProductService ps=new ProductServiceImpl();
        //获取商品列表
        ArrayList<Product> ap=ps.checkProductService();
        //存储到ServletContext
        sc.setAttribute("products",ap);
    }

    private void checkOrder(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        HttpSession hs=req.getSession();
        int userID=((User)hs.getAttribute("user")).getUid();
        OrderService os=new OrderServiceImpl();
        ArrayList<Order> ao=os.checkOrderService(userID);
        hs.setAttribute("orders",ao);
    }

    private void addOrder(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        HttpSession hs=req.getSession();
        int userID=((User)hs.getAttribute("user")).getUid();
        OrderService os=new OrderServiceImpl();
        os.addOrderService(userID);
        checkShoppingCart(req,resp);
    }

    private void checkShoppingCart(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        HttpSession hs=req.getSession();
        int userID=((User)hs.getAttribute("user")).getUid();
        ShoppingCartService scs=new ShoppingCartServiceImpl();
        ShoppingCart sc=scs.checkShoppingCartService(userID);
        resp.getWriter().write(new Gson().toJson(sc));
    }

    private void addProduct(HttpServletRequest req,HttpServletResponse resp) throws SQLException {
        HttpSession hs=req.getSession();
        int userID=((User)hs.getAttribute("user")).getUid();
        int ID=Integer.parseInt(req.getParameter("ID"));
        ShoppingCartService scs=new ShoppingCartServiceImpl();
        scs.addProductService(ID,userID);
    }

    private void deleteProduct(HttpServletRequest req,HttpServletResponse resp) throws SQLException {
        HttpSession hs=req.getSession();
        int userID=((User)hs.getAttribute("user")).getUid();
        int ID=Integer.parseInt(req.getParameter("ID"));
        ShoppingCartService scs=new ShoppingCartServiceImpl();
        scs.deleteProductService(ID,userID);
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession hs=req.getSession();
        hs.invalidate();
        resp.sendRedirect("/ZY2018003012543/index.jsp");
        return;
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String user=req.getParameter("user");
        String password=req.getParameter("pwd");
        //处理请求数据
            //获取service层对象
            UserService us=new UserServiceImpl();
            //校验
            User u=us.checkUserLoginService(user,password);
            if (u!=null)
            {
                //获取session对象
                HttpSession hs=req.getSession();
                hs.setAttribute("user",u);
                //重定向
                resp.sendRedirect("/ZY2018003012543/main.jsp");
                return;
            }else
                {
                    req.setAttribute("flag",0);
                    req.getRequestDispatcher("/index.jsp").forward(req,resp);
                }
    }
}
