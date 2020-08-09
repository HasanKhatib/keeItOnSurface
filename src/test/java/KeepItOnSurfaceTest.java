import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import surface.Position;
import surface.Table;

public class KeepItOnSurfaceTest {

    @Test
    public void ApplyLeftMovementShouldAffectXWhenFacingNorth() {
        Table table = Mockito.spy(new Table());
        Position position = new Position(1, 1);
        Mockito.doReturn(4).when(table).getyDimension();
        Mockito.doReturn(4).when(table).getxDimension();
        Assert.assertEquals(
                table.applyMovementCommand(4, position).getPositionX(),
                0);
    }

    @Test
    public void ApplyForwardMovementShouldAffectYWhenFacingNorth() {
        Table table = Mockito.spy(new Table());
        Position position = new Position(1, 1);
        Mockito.doReturn(4).when(table).getyDimension();
        Mockito.doReturn(4).when(table).getxDimension();
        Assert.assertEquals(
                table.applyMovementCommand(1, position).getPositionY(),
                0);
    }

    @Test
    public void ApplyBackwardMovementShouldAffectYAndDirectionWhenFacingSouth() {
        Table table = Mockito.spy(new Table());
        Position position = new Position(1, 1, 'S');
        Mockito.doReturn(4).when(table).getyDimension();
        Mockito.doReturn(4).when(table).getxDimension();
        Assert.assertEquals(
                table.applyMovementCommand(2, position).getPositionY(),
                0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void ShouldThrowExceptionWhenObjectOutOfSurface() {
        Table table = Mockito.spy(new Table());
        Position position = new Position(-1, 0);
        Mockito.doReturn(4).when(table).getyDimension();
        Mockito.doReturn(4).when(table).getxDimension();
        table.validatePosition(position);
    }
}