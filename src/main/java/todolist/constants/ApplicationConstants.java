package todolist.constants;

public enum ApplicationConstants {

    SERVICE,
    TASK_SERVICE_TYPE("TaskServiceHibernateImpl"),
    MAX_TASKS_PER_HTML_PAGE(3);

    private String value;
    private int param;

    ApplicationConstants() {

    }

    ApplicationConstants(String con) {
        this.value = con;
    }

    ApplicationConstants(int i) {
        this.param = i;
    }

    public int getParam() {
        return param;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() { //? Как лучше использовать энам, чтобы запись была короче?
        return this.value;
    }
}
