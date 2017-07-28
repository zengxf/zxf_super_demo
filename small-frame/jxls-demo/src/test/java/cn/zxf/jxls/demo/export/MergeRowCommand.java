package cn.zxf.jxls.demo.export;

import java.util.Collection;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.jxls.area.Area;
import org.jxls.command.AbstractCommand;
import org.jxls.command.Command;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.common.Size;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.UtilWrapper;

import cn.zxf.jxls.demo.dto.GroupDto;
import lombok.Data;

@Data
public class MergeRowCommand extends AbstractCommand {

    private UtilWrapper	util = new UtilWrapper();
    Area		area;
    private String	var;
    private String	items;

    public String getName() {
	return "mergeRow";
    }

    @SuppressWarnings( "unchecked" )
    public Size applyAt( CellRef cellRef, Context context ) {
	Size resultSize = area.applyAt( cellRef, context );
	if ( resultSize.equals( Size.ZERO_SIZE ) )
	    return resultSize;

	PoiTransformer transformer = (PoiTransformer) area.getTransformer();
	Workbook workbook = transformer.getWorkbook();
	Sheet sheet = workbook.getSheet( cellRef.getSheetName() );
	Collection<GroupDto> itemsCollection = null;
	try {
	    itemsCollection = util.transformToCollectionObject( getTransformationConfig().getExpressionEvaluator(), items, context );
	    itemsCollection.forEach( group -> {
		System.out.println( group );
	    } );
	    sheet.addMergedRegion( new CellRangeAddress( 1, 2, 1, 1 ) );
	} catch ( Exception e ) {
	    e.printStackTrace();
	}

	return resultSize;
    }

    @Override
    public Command addArea( Area area ) {
	super.addArea( area );
	this.area = area;
	return this;
    }

}
