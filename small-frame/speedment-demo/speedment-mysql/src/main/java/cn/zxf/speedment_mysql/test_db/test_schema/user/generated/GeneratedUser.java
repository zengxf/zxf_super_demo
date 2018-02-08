package cn.zxf.speedment_mysql.test_db.test_schema.user.generated;

import cn.zxf.speedment_mysql.test_db.test_schema.user.User;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.field.IntField;
import com.speedment.runtime.field.LongField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;

/**
 * The generated base for the {@link
 * cn.zxf.speedment_mysql.test_db.test_schema.user.User}-interface representing
 * entities of the {@code user}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedUser {
    
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getId()} method.
     */
    LongField<User, Long> ID = LongField.create(
        Identifier.ID,
        User::getId,
        User::setId,
        TypeMapper.primitive(), 
        true
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getName()} method.
     */
    StringField<User, String> NAME = StringField.create(
        Identifier.NAME,
        User::getName,
        User::setName,
        TypeMapper.identity(), 
        true
    );
    /**
     * This Field corresponds to the {@link User} field that can be obtained
     * using the {@link User#getAge()} method.
     */
    IntField<User, Integer> AGE = IntField.create(
        Identifier.AGE,
        User::getAge,
        User::setAge,
        TypeMapper.primitive(), 
        false
    );
    
    /**
     * Returns the id of this User. The id field corresponds to the database
     * column hellospeedment.hellospeedment.user.id.
     * 
     * @return the id of this User
     */
    long getId();
    
    /**
     * Returns the name of this User. The name field corresponds to the database
     * column hellospeedment.hellospeedment.user.name.
     * 
     * @return the name of this User
     */
    String getName();
    
    /**
     * Returns the age of this User. The age field corresponds to the database
     * column hellospeedment.hellospeedment.user.age.
     * 
     * @return the age of this User
     */
    int getAge();
    
    /**
     * Sets the id of this User. The id field corresponds to the database column
     * hellospeedment.hellospeedment.user.id.
     * 
     * @param id to set of this User
     * @return   this User instance
     */
    User setId(long id);
    
    /**
     * Sets the name of this User. The name field corresponds to the database
     * column hellospeedment.hellospeedment.user.name.
     * 
     * @param name to set of this User
     * @return     this User instance
     */
    User setName(String name);
    
    /**
     * Sets the age of this User. The age field corresponds to the database
     * column hellospeedment.hellospeedment.user.age.
     * 
     * @param age to set of this User
     * @return    this User instance
     */
    User setAge(int age);
    
    enum Identifier implements ColumnIdentifier<User> {
        
        ID   ("id"),
        NAME ("name"),
        AGE  ("age");
        
        private final String columnName;
        private final TableIdentifier<User> tableIdentifier;
        
        Identifier(String columnName) {
            this.columnName      = columnName;
            this.tableIdentifier = TableIdentifier.of(    getDbmsName(), 
                getSchemaName(), 
                getTableName());
        }
        
        @Override
        public String getDbmsName() {
            return "hellospeedment";
        }
        
        @Override
        public String getSchemaName() {
            return "hellospeedment";
        }
        
        @Override
        public String getTableName() {
            return "user";
        }
        
        @Override
        public String getColumnName() {
            return this.columnName;
        }
        
        @Override
        public TableIdentifier<User> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}