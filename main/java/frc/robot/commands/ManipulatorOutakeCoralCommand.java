public class ManipulatorOutake extends Command {
    private final double speed;
    private final ManipulatorSubsystem manipulator;
    public ManipulatorOutake(ManipulatorSubsystem manipulator, double speed) {
        this.manipulator = manipulator;
        this.speed = speed;
        addRequiremnets(manipulator);
    }
        @Override
        public void execute() {
            manipulator.spinFoward(speed);
        }
        @Override
        public void end(boolean interrupted) {
            manipulator.spinFoward(0);
        }
}