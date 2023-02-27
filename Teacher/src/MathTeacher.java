public class MathTeacher implements ITeacher{
    private WisdomWordsService wisdomService;
    public void setWisdomService(WisdomWordsService wisdomService) {
        this.wisdomService = wisdomService;
    }

    @Override
    public String getMessage() {
        return "Solve 100 calculus problems";
    }

    @Override
    public String getWisdom() {
        return "the shortest way is straight";
    }

    @Override
    public String getHomeWork() {
        return "run for your life";
    }
}
