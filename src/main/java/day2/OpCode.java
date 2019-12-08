package day2;

public enum OpCode {
    ADD(1),
    MUL(2),
    FIN(99);

    private int opCode;

    OpCode(int opCode) {
        this.opCode = opCode;
    }

    public int getOpCode() {
        return opCode;
    }

    public static OpCode fromIntValue(int input) {
        for (OpCode operation : values()) {
            if (input == operation.opCode) {
                return operation;
            }
        }
        return FIN;
    }
}
