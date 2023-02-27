public class HistoryTeacher implements ITeacher{
    @Override
    public String getMessage() {
        return "Learn about WWII";
    }

    @Override
    public String getWisdom() {
        return "he who doesnt know his history is doomed to repeat it";
    }

    @Override
    public String getHomeWork() {
        return "create your timeline";
    }
}
