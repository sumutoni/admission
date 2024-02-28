package Service;

import Model.Form;
import java.util.List;

public interface FormServiceInterface {
    public boolean SaveForm(Form form);
    public List<Form> getForms();
    public Form getForm(int id);
    public boolean updateStatus(int id, String status);
}
