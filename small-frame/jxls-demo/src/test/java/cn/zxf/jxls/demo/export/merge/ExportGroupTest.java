package cn.zxf.jxls.demo.export.merge;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.common.AreaListener;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;

import cn.zxf.jxls.demo.dto.GroupDto;
import cn.zxf.jxls.demo.dto.UserDto;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * A1 备注：jx:area(lastCell="D2")
 * A2 备注：jx:each(items="groups" var="group" lastCell="B2")
 * C2 备注：jx:each(items="group.users" var="user" lastCell="D2")
 * </pre>
 * 
 * <p>
 * Created by zxf on 2017-07-27
 */
@Slf4j
public class ExportGroupTest {

    public static void main( String[] args ) throws FileNotFoundException, IOException {
        List<UserDto> users = new ArrayList<>();
        users.add( UserDto.builder().name( "zxf" ).age( 32 ).build() );
        users.add( UserDto.builder().name( "zxf-1" ).build() );
        List<GroupDto> groups = new ArrayList<>();
        groups.add( GroupDto.builder().id( "group-001" ).name( "zxf-屠龙组" ).users( users ).build() );
        groups.add( GroupDto.builder().id( "group-002" ).name( "zxf-屠龙组2" ).users( users ).build() );

        log.info( "path: {}", ExportGroupTest.class.getResource( "/group-template.xlsx" ).getFile() );
        log.info( "\n\t groups: {}", groups );

        try ( InputStream is = ExportGroupTest.class.getResourceAsStream( "/group-template.xlsx" ) ) {
            try ( OutputStream os = new FileOutputStream( "output/group-output.xlsx" ) ) {
                Context context = new Context();
                context.putVar( "groups", groups );

                JxlsHelper helper = JxlsHelper.getInstance();
                Transformer transformer = helper.createTransformer( is, os );
                AreaBuilder areaBuilder = helper.getAreaBuilder();
                areaBuilder.setTransformer( transformer );

                List<Area> xlsAreaList = areaBuilder.build();
                for ( Area xlsArea : xlsAreaList ) {
                    xlsArea.addAreaListener( new MyAreaListener() );
                    xlsArea.applyAt( new CellRef( xlsArea.getStartCellRef().getCellName() ), context );
                }
                transformer.write();
            }
        }

        log.info( "ok !!!" );
    }

    static class MyAreaListener implements AreaListener {
        @Override
        public void beforeApplyAtCell( CellRef cellRef, Context context ) {
        }

        @Override
        public void afterApplyAtCell( CellRef cellRef, Context context ) {
        }

        @Override
        public void beforeTransformCell( CellRef srcCell, CellRef targetCell, Context context ) {
        }

        @Override
        public void afterTransformCell( CellRef srcCell, CellRef targetCell, Context context ) {
            log.info( "src ====> {}, {}, {}", srcCell.getCol(), srcCell.getRow(), srcCell );
            log.info( "target ====> {}, {}, {}", targetCell.getCol(), targetCell.getRow(), targetCell );
        }
    }

}
