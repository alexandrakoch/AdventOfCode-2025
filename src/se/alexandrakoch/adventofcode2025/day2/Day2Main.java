import se.alexandrakoch.adventofcode2025.day2.Controller;

void main() throws IOException {
    Controller controller = new Controller(this.getClass().getResourceAsStream("/day2.txt"));
    System.out.println(controller.getAnswer());
}
