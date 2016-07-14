package org.dj.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import org.dj.models.BeatModel;

@WebServlet(
    name="DJViewServlet",
    urlPatterns={"/","/servlet/djview"}
)
public class DJViewServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;

    private static final String MODEL_ATTRIBUTE_KEY = "beatModel";

    @Override
    public void init() throws ServletException {
        BeatModel beatModel = new BeatModel();
        beatModel.initialize();
        getServletContext().setAttribute(MODEL_ATTRIBUTE_KEY, beatModel);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BeatModel beatModel = (BeatModel)getServletContext().getAttribute(MODEL_ATTRIBUTE_KEY);

        String bpm = request.getParameter("bpm");
        if(bpm == null) {
            bpm = String.valueOf(beatModel.getBPM());
        }

        String set = request.getParameter("set");
        if(set != null) {
            int bpmNumber = Integer.parseInt(bpm);
            beatModel.setBPM(bpmNumber);
        }

        String decrease = request.getParameter("decrease");
        if(decrease != null) {
            beatModel.setBPM(beatModel.getBPM() - 1);
        }

        String increase = request.getParameter("increase");
        if(increase != null) {
            beatModel.setBPM(beatModel.getBPM() + 1);
        }

        String on = request.getParameter("on");
        if(on != null) {
            beatModel.on();
        }

        String off = request.getParameter("off");
        if(off != null) {
            beatModel.off();
        }

        request.setAttribute(MODEL_ATTRIBUTE_KEY, beatModel);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/DJView.jsp");
        dispatcher.forward(request, response);
    }
}
