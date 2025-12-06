import se.alexandrakoch.adventofcode2025.day1.Dial;

void main() {
    int password = 0;
    Dial dial = new Dial();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/day1.txt")))) {
        String line;
        while ((line = reader.readLine()) != null) {
            char direction = line.charAt(0);
            int value = Integer.parseInt(line.substring(1));
            if (dial.turnDial(direction, value)) {
                password++;
            }
        }
        System.out.println("The password is: " + password);
    } catch (IOException e) {
        System.out.println("Error reading file");
    } catch (NullPointerException e) {
        System.out.println("File not found");
    }


}
