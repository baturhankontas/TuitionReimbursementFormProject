package dev.kontas.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dev.kontas.controllers.EmployeeController;
import dev.kontas.controllers.EventController;
import dev.kontas.controllers.Tuition_FormController;

public class RequestHelper {
	
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String uri = request.getRequestURI();
		
		System.out.println(uri);

		switch (uri) {
		///works
		case "/TuitionPro/getLogin.do": {												//WORKS
			EmployeeController.getLogin(request, response);
		}break;
		case "/TuitionPro/createEvent.do":{												//WORKS
			EventController.addEvent(request, response);
		}break;
		case "/TuitionPro/createForm.do":{												//WORKS
			Tuition_FormController.createForm(request,response);
		}break;
		case "/TuitionPro/addGrade.do":{												
			EventController.addGrade(request, response);
		}break;
		case "/TuitionPro/getEvents.do":{												// gets personal events
			EventController.getEvent(request, response);
		}break;
		case "/TuitionPro/getForm.do":{													//gets list of forms for current user
			Tuition_FormController.getAllForms(request,response);
		}break;
		
		case "/TuitionPro/addApproval.do":{													//gets list of forms for current user
			EventController.addApproval(request,response);
		}break;
		case "/TuitionPro/updateForm.do":{												//tonew comment
			Tuition_FormController.addNewComment(request,response);
		}break;
		case "/TuitionPro/addToOldForm.do":{												//tonew comment
			Tuition_FormController.addtoOldComment(request,response);
		}break;
		case "/TuitionPro/seeApproves.do":{
			Tuition_FormController.seeApproves(request, response);
		}break;
		case "/TuitionPro/getGrade.do":{															/////look at this
			EventController.getGrade(request, response);
		}break;
		case "/TuitionPro/logOut.do":{															/////look at this
			EmployeeController.logOut(request, response);
		}break;
		case "/TuitionPro/seeGradeOfAll.do":{															/////look at this
			EventController.seeGradesOfAll(request, response);
		}break;
		case "/TuitionPro/getUser.do":{															/////look at this
			EmployeeController.getUser(request, response);
		}break;
		case "/TuitionPro/getMyEvent.do":{															/////look at this
			EventController.getMyEvent(request, response);
		}break;
		case "/TuitionPro/addApprove.do":{															/////look at this
			Tuition_FormController.addApprove(request, response);
		}break;
		default: {
			response.sendError(418, "Default case hit. Cannot brew coffee, is teapot.");
			break;
		}
		
		}

	}

}
