package Service;

import java.util.List;

import Model.Form;
import Repository.FormRepository;

public class FormService implements FormServiceInterface {

    private final FormRepository formRepository =  new FormRepository();
    @Override
    public boolean SaveForm(Form form) {
        return formRepository.saveForm(form);
    }

    @Override
    public List<Form> getForms() {
        return formRepository.getForms();
    }

    @Override
    public Form getForm(int id) {
        return formRepository.getForm(id);
    }

    @Override
    public boolean updateStatus(int id, String status) {
        return formRepository.updateStatus(id, status);
    }
    
}
