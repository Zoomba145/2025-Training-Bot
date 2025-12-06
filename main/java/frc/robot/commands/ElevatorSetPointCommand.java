public class ElevatorSetPoint extends Command {
    private final double speed;
    private final ElevatorSubsystem elevator;
    public ElevatorSetPoint(ElevatorSubsystem elevator, double speed) {
        this.elevator = elevator;
        this.speed = speed;
        addRequiremnets(elevator);
    }
        @Override
        public void execute() {
            elevator.moveElevator(speed);
        }
        @Override
        public void end(boolean interrupted) {
            elevator.moveElevator(0);
        }
}