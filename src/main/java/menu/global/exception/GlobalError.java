package menu.global.exception;

import menu.global.exception.base.MenuPlannerError;

public enum GlobalError implements MenuPlannerError {

    /** 입력 에러 */
    ;

    private final String errorMessage;

    GlobalError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
