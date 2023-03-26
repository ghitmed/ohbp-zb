
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller public class UserController {


    @GetMapping("/showDoctorDashboard")
    public String showDoctorDashboard(Model model) {
        return "doctor_dashboard_radno.html";


    }
}