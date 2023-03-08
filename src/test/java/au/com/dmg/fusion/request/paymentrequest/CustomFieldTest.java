/*
 * Copyright (c) 2023. DatameshGroup
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package au.com.dmg.fusion.request.paymentrequest;

import au.com.dmg.fusion.data.CustomFieldType;
import org.junit.Test;


public class CustomFieldTest {

    @Test
    public void testValid(){
        CustomField customField = new CustomField.Builder()
                .value(10)
                .type(CustomFieldType.Integer)
                .key("key")
                .build();
    }

    @Test
    public void testInvalidType(){
        try{
            CustomField customField = new CustomField.Builder()
                    .value(10)
                    .type(CustomFieldType.Boolean)
                    .key("key")
                    .build();
            assert(false);
        } catch (IllegalArgumentException arg){
            assert(true);
        }
    }


    @Test
    public void testInvalidTypeArray(){
        try{
            CustomField customField = new CustomField.Builder()
                    .value("[1,2,3]")
                    .type(CustomFieldType.Object)
                    .key("key")
                    .build();
            assert(false);
        } catch (IllegalArgumentException arg){
            assert(true);
        }
    }

    @Test
    public void testMalformedArray(){
        try{
            CustomField customField = new CustomField.Builder()
                    .value("[123,44")
                    .type(CustomFieldType.Array)
                    .key("key")
                    .build();
            assert(false);
        } catch (IllegalArgumentException arg){
            assert(true);
        }
    }

    @Test
    public void testMalformedArray2(){
        try{
            CustomField customField = new CustomField.Builder()
                    .value("[test]")
                    .type(CustomFieldType.Array)
                    .key("key")
                    .build();
            assert(false);
        } catch (IllegalArgumentException arg){
            assert(true);
        }
    }

    @Test
    public void testValidTypeObject(){
        CustomField customField = new CustomField.Builder()
                .value("{}")
                .type(CustomFieldType.Object)
                .key("key")
                .build();
    }

    @Test
    public void testValidTypeObject2(){
        CustomField customField = new CustomField.Builder()
                .value("{\"1\": 2, \"2\": 3, \"4\": 11}")
                .type(CustomFieldType.Object)
                .key("key")
                .build();
    }

    @Test
    public void testValidTypeObject3(){
        CustomField customField = new CustomField.Builder()
                .value("{\"a\": \"hello world\"}")
                .type(CustomFieldType.Object)
                .key("key")
                .build();
    }

    @Test
    public void testValidTypeObject4(){
        CustomField customField = new CustomField.Builder()
                .value("{\"x\" : { \"y\": \"z\", \"z\": 2}}")
                .type(CustomFieldType.Object)
                .key("key")
                .build();
    }

}