import java.io.*;

class Parser{
    static int lookahead;

    public Parser() throws IOException{
        // read
        // System.out.println("[*] Parser()");
        lookahead = System.in.read();           // just one ASCII
    }

    void expr() throws IOException{
        // convert
        // System.out.println("[*] expr()");

        // 1. sync
        term();

        // 2. convert
        while(true){
            if(lookahead == '+'){
                match('+');
                term();
                System.out.write('+');
            }else if(lookahead == '-'){
                match('-');
                term();
                System.out.write('-');
            }else{
                return;
            }
        }
    }

    void term() throws IOException{
        // sync check
        // System.out.println("[*] term()");

        if(Character.isDigit((char)lookahead)){
            System.out.write((char)lookahead);
            match(lookahead);
        }else{
            throw new Error("Syntax Error");
        }
    }

    void match(int t) throws IOException{
        // input
        // System.out.println("[*] match()");

        if(lookahead == t){
            lookahead = System.in.read();
        }else{
            throw new Error("Syntax Error");
        }
    }

    public static void main(String[] args) throws IOException{
        // System.out.println("[*] Hello World");

        Parser parser = new Parser();
        parser.expr();

        // System.out.write('\n');
        System.out.flush();                 // If the byte is a newline and automatic flushing is enabled then the flush method will be invoked.
    }
}
