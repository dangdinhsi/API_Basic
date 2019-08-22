package api;

import com.google.gson.Gson;
import entity.Hero;
import entity.JsonResponse;
import model.HeroModel;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloAPI extends HttpServlet {

    private static HeroModel model = new HeroModel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        model.listHero();
        JsonResponse jsonResponse = new JsonResponse(HttpServletResponse.SC_OK,"Get list ok!!!",model.listHero());
        resp.getWriter().println(new Gson().toJson(jsonResponse));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
       resp.setCharacterEncoding("utf-8");
       String content = StringUtil.convertInputStreamToString(req.getInputStream());
       Hero hero = new Gson().fromJson(content,Hero.class);
       model.saveHero(hero);
       resp.setStatus(HttpServletResponse.SC_CREATED);
       JsonResponse jsonResponse = new JsonResponse(HttpServletResponse.SC_CREATED,"save success!!!",model.saveHero(hero));
       resp.getWriter().println(new Gson().toJson(jsonResponse));
    }
}
