package Servlets;

import Crud.CrudInterface;
import Crud.FileCrud;

public class ServletConfig implements ServletConfigInterface {

    CrudInterface ci;

    public ServletConfig() {
        this.ci = new FileCrud();
    }

    public void setCi(CrudInterface ci) {
        this.ci = ci;
    }

    @Override
    public CrudInterface getCrud() {
        return ci;
    }
}
